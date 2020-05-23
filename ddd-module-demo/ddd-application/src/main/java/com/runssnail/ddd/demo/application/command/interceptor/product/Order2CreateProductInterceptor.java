package com.runssnail.ddd.demo.application.command.interceptor.product;

import com.runssnail.ddd.command.interceptor.CommandInterceptor;
import com.runssnail.ddd.common.result.Result;
import com.runssnail.ddd.demo.client.dto.command.product.CreateProductCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zhengwei
 * @date 2019-11-06 12:03
 **/
@Component
@Order(2)
public class Order2CreateProductInterceptor implements CommandInterceptor<CreateProductCommand, Result> {

    private static final Logger log = LoggerFactory.getLogger(Order2CreateProductInterceptor.class);

    @Override
    public Class<CreateProductCommand> supportCommandType() {
        return CreateProductCommand.class;
    }

    @Override
    public void beforeHandle(CreateProductCommand command) {
        log.info("Order2CreateProductInterceptor.preHandle");
    }

    @Override
    public void afterHandle(CreateProductCommand command, Result result) {
        log.info("Order2CreateProductInterceptor.postHandle");
    }
}
