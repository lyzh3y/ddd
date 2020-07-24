package com.runssnail.ddd.commandhandling.handler;

import com.runssnail.ddd.common.command.Command;
import com.runssnail.ddd.common.exception.BaseException;
import com.runssnail.ddd.common.exception.BasicErrorCode;
import com.runssnail.ddd.common.result.BaseResult;

import lombok.extern.slf4j.Slf4j;

/**
 * 默认异常处理器
 *
 * @author zhengwei
 * @date 2019/3/26 10:36 AM
 **/
@Slf4j
public class DefaultCommandExceptionHandler implements CommandExceptionHandler {

    @Override
    public void onException(Command command, BaseResult result, Throwable t) {
        buildResult(result, t);
        printLog(command, result, t);
    }


    private void printLog(Command cmd, BaseResult result, Throwable exception) {
        if ((exception instanceof BaseException) || (exception instanceof IllegalArgumentException)) {
            log.info(buildErrorMsg(cmd, result, exception));
        } else {
            log.error(buildErrorMsg(cmd, result, exception), exception);
        }
    }

    private String buildErrorMsg(Command cmd, BaseResult result, Throwable exception) {
        return "handle [" + cmd + "] failed, errorCode: " + result.getCode() + ", errorMsg:" + result.getMessage() + ", exceptionMsg:" + exception.getMessage();
    }

    private void buildResult(BaseResult result, Throwable t) {
        if (t instanceof IllegalArgumentException) {
            result.setCode(BasicErrorCode.PARAMS_ERROR.getErrorCode());
            result.setMessage(t.getMessage());
        } else if (t instanceof BaseException) {
            BaseException baseException = ((BaseException) t);
            result.setCode(baseException.getErrorCode());
            result.setMessage(baseException.getErrorMsg());
        } else {
            result.setCode(BasicErrorCode.SYS_ERROR.getErrorCode());
            result.setMessage(BasicErrorCode.SYS_ERROR.getErrorMsg());
        }
    }
}
