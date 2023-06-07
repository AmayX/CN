import java.net.*;
import java.io.*;
public class SClient {
public static void main(String args[]) throws IOException {
Socket s1 = new Socket("localhost", 1254);
InputStream s1In = s1.getInputStream(); 
DataInputStream dis = new DataInputStream(s1In);
OutputStream s1out = s1.getOutputStream(); 
DataOutputStream dos = new DataOutputStream(s1out);
BufferedReader scan = new BufferedReader(new
InputStreamReader(System.in));
int n = dis.read();
System.out.println("Number of frames are " + n); 
int i;
int b[] = new int[n];
for(i=0;i<n;i++) {
b[i] = dis.read();
}
b[2] = -1;
for(i=0;i<n;i++){
System.out.print(b[i] + " ");
}
for(i=0;i<n;i++){
if(b[i]==-1){
dos.write(i);
b[i] = dis.read();
}}
System.out.println("");
for(i=0;i<n;i++){
System.out.print(b[i] + " ");
}
dis.close();
s1In.close();
s1.close();
}
}