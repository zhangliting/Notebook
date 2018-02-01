import java.util.Date;

public class InitializationOnDemand {
    private Date date = new Date();

    private InitializationOnDemand(){
    }

    public static InitializationOnDemand getInstance(){
        return Holder.instance;
    }

    //只有第一次调用时才创建对象
    private static class Holder{
        public static InitializationOnDemand instance = new InitializationOnDemand();
    }
}

