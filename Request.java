/**
 * Created by wwh on 15-7-30.
 */
public class Request {
    public int ablity;
    Request(int ablity){ this.ablity = ablity; }
    public static void main (String[] args) throws Exception{
        Handler hd1 = new HandlerRequest_one(100);
        Handler hd2 = new HandlerRequest_two(500);
        hd1.setNextHandler(hd2);
        Request req1 = new Request(50);
        hd1.handleRequest(req1.ablity);
        System.out.println("-------------------------");
        Request req2 = new Request(300);
        hd1.handleRequest(req2.ablity);
        System.out.println("-------------------------");
        Request req3 = new Request(500);
        hd1.handleRequest(req3.ablity);
    }
}
