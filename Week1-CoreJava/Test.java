public class Test {

    public static void main(String[] args){
        String message = "";
        for(int i=0; i<args.length; i++){
            message = message + args[i] + " ";
        }
        System.out.println("Hello World "+message);
    }

}