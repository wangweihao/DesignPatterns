/**
 * Created by wwh on 15-7-30.
 */
public abstract class Handler {

    /* 能力值 */
    protected int abilityToValue = 0;

    /* 持有下一个对象的引用 */
    protected Handler nextHandler;

    /* 具体的处理方法 */
    public abstract void handleRequest(int vaule);

    /* 得到下一个对象的引用 */
    public Handler getNextHandler(){
        if(nextHandler != null) {
            return nextHandler;
        }
        else{
            /* 到达责任链末尾，未能处理 */
            System.out.println("该待处理对象被责任链放过...");
        }
        return null;
    }

    /* 设置后继的处理对象 */
    public void setNextHandler(Handler nextHandler){
        if(nextHandler != null) {
            this.nextHandler = nextHandler;
        }else{
            System.out.println("到达末尾，设置完成责任链");
        }
    }
}

class HandlerRequest_one extends Handler{
    /* 设置能力值 */
    HandlerRequest_one(int atv){
        this.abilityToValue = atv;
    }
    /* 具体的处理请求方法 */
    @Override
    public void handleRequest(int value) {
        /* 如果处理对象的能力值在100-200范围内，那么处理此请求，
        否则没有能力处理此请求，交给下一个handler */
        if(abilityToValue > value){
            System.out.println("HandlerRequest_one 处理请求");
        }else{
            System.out.println("HandlerRequest_one 放过请求，传递给下一个Handler");
            if(getNextHandler() != null)
                getNextHandler().handleRequest(value);
        }
    }
}

class HandlerRequest_two extends Handler{
    /* 设置能力值 */
    HandlerRequest_two(int atv){
        this.abilityToValue = atv;
    }

    @Override
    public void handleRequest(int value) {
        /* 如果处理对象的能力值在200-400范围内，那么处理此请求，
        * 否则没有能力处理此请求，交给下一个handler */
        if(abilityToValue > value){
            System.out.println("HandlerRequest_two 处理请求");
        }else{
            System.out.println("HandlerRequest_two 放过请求，传递给下一个handler");
            if(getNextHandler() != null)
                getNextHandler().handleRequest(value);
        }
    }
}
