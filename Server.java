import java.io.*;
import java.net.*;
public class Server
{
  public static void main(String[] args) throws Exception
  {
      ServerSocket serverSocket = new ServerSocket(3000);
      System.out.println("Server  ready for chatting");
      Socket socket = serverSocket.accept( );                          
                              // reading from keyboard (keyRead object)
      BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
	                      // sending to client (pwrite object)
      OutputStream ostream = socket.getOutputStream(); 
      PrintWriter pwrite = new PrintWriter(ostream, true);
 
                              // receiving from server ( receiveRead  object)
      InputStream istream = socket.getInputStream();
      BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
 
      String receiveMessage, sendMessage;               
      while(true)
      {
        if((receiveMessage = receiveRead.readLine()) != null)  
        {
           System.out.println(receiveMessage);         
        }         
        sendMessage = keyRead.readLine(); 
        pwrite.println(sendMessage);             
        pwrite.flush();
      }               
    }                    
}  