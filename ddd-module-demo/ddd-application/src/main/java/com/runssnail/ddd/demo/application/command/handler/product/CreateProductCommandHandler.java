package com.runssnail.ddd.demo.application.command.handler.product;

import com.runssnail.ddd.command.handler.BaseCommandHandler;
import com.runssnail.ddd.common.result.Result;
import com.runssnail.ddd.demo.client.dto.command.product.CreateProductCommand;
import com.runssnail.ddd.demo.domain.event.product.ProductCreatedEvent;
import com.runssnail.ddd.demo.domain.model.product.Product;
import com.runssnail.ddd.demo.domain.repository.ProductRepository;
import com.runssnail.ddd.demo.domain.service.ProductDomainService;
import com.runssnail.ddd.event.EventBus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhengwei
 * @date 2019-11-05 14:50
 **/
@Component
public class CreateProductCommandHandler extends BaseCommandHandler<CreateProductCommand, Result> {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDomainService productDomainService;

    @Autowired
    private EventBus eventBus;

    @Override
    public Class<CreateProductCommand> supportCommand() {
        return CreateProductCommand.class;
    }

    @Override
    public Result<String> doHandle(CreateProductCommand command) {

        // 转换领域对象
        Product product = this.productDomainService.createProduct(command);

        // 保存数据
        productRepository.save(product);

        // 发布领域事件
        eventBus.publish(new ProductCreatedEvent(product.getProductId()));

        return Result.success(product.getProductId());
    }
}
