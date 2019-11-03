package com.itcode.environment.result;

public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    //成功
    public static Result getSuccessResult() {
        return new Result().setCode(ResultCodeEnum.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Result<T> getSuccessResult(T data) {
        return new Result().setCode(ResultCodeEnum.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE).setData(data);
    }

    public static Result getFailResult(String data) {
        return new Result().setCode(ResultCodeEnum.FAIL).setMessage("请求失败，请重试！").setData(data);
    }

    public static Result getUnauthorizedResult() {
        return new Result().setCode(ResultCodeEnum.UNAUTHORIZED).setMessage("权限不足！").setData("权限不足！");
    }

    public static Result getErrorResult(){
        return new Result().setCode(ResultCodeEnum.INTERNAL_SERVER_ERROR).setMessage("服务器错误!").setData("服务器错误!");
    }

    public static <T> Result<T> getErrorResult(T data) {
        return new Result().setCode(ResultCodeEnum.INTERNAL_SERVER_ERROR).setMessage("服务器错误").setData(data);
    }

    public static Result getNotLoginResult(){
        return new Result().setCode(ResultCodeEnum.NOT_LOING).setMessage("用户未登录").setData("用户未登录");
    }
}


