package com.runssnail.ddd.commandhandling.validator;

import java.util.List;

import com.runssnail.ddd.common.command.Command;
import com.runssnail.ddd.common.result.Result;
import com.runssnail.ddd.common.validator.CommandValidator;
import com.runssnail.ddd.common.validator.GlobalCommandValidator;

/**
 * 命令验证器解析器
 *
 * @author zhengwei
 * @date 2019-11-07 15:34
 **/
public interface CommandValidatorResolver {

    /**
     * 找到对应命令验证器
     *
     * @param command 命令
     * @return Validator 命令验证器
     */
    <C extends Command<T>, T extends Result> CommandValidator<C> resolve(Command<T> command);

    /**
     * 注册(运行时注册注意并发问题)
     *
     * @param validator 命令验证器
     * @param <C>
     */
    <C extends Command> void registerValidator(CommandValidator<C> validator);

    /**
     *
     * 获取全局的验证器
     *
     * @return 全局的验证器
     */
    List<GlobalCommandValidator> getGlobalValidators();
}
