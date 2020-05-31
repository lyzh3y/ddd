package com.runssnail.ddd.demo.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.runssnail.ddd.command.CommandBus;
import com.runssnail.ddd.common.result.PagingResult;
import com.runssnail.ddd.common.result.Result;
import com.runssnail.ddd.demo.client.dto.ProductDTO;
import com.runssnail.ddd.demo.client.dto.command.product.ActivateProductCommand;
import com.runssnail.ddd.demo.client.dto.command.product.CreateProductCommand;
import com.runssnail.ddd.demo.client.dto.command.product.DeactivateProductCommand;
import com.runssnail.ddd.demo.client.dto.command.product.GetProductCommand;
import com.runssnail.ddd.demo.client.dto.command.product.QueryProductCommand;
import com.runssnail.ddd.demo.client.dto.command.product.RemoveProductCommand;
import com.runssnail.ddd.demo.client.dto.command.product.UpdateProductCommand;

/**
 * @author zhengwei
 * @date 2019-11-05 14:38
 **/
@Component
public class ProductApplicationService {

    @Autowired
    private CommandBus commandBus;

    /**
     * 创建商品
     *
     * @param command
     * @return
     */
    @Transactional
    public Result<String> createProduct(CreateProductCommand command) {
        return commandBus.dispatch(command);
    }

    public Result<ProductDTO> getProduct(GetProductCommand command) {
        return commandBus.dispatch(command);
    }

    @Transactional
    public Result<String> updateProduct(UpdateProductCommand command) {
        return commandBus.dispatch(command);
    }

    @Transactional
    public Result<String> activateProduct(ActivateProductCommand command) {
        return commandBus.dispatch(command);
    }

    @Transactional
    public Result<String> deactivateProduct(DeactivateProductCommand command) {
        return commandBus.dispatch(command);
    }

    @Transactional
    public Result<String> removeProduct(RemoveProductCommand command) {
        return commandBus.dispatch(command);
    }

    public PagingResult<ProductDTO> queryProducts(QueryProductCommand command) {
        return commandBus.dispatch(command);
    }
}
