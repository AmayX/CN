import java.net.*;
import java.io.*;
import java.util.Scanner;
public class GServer {
public static void main(String args[]) throws IOException {
ServerSocket s = new ServerSocket(1254);
Socket s1 = s.accept(); 
OutputStream s1out = s1.getOutputStream();
DataOutputStream dos = new DataOutputStream(s1out);
InputStream s1In = s1.getInputStream();
DataInputStream dis = new DataInputStream(s1In);
BufferedReader scan = new BufferedReader(new
InputStreamReader(System.in));
Scanner sc = new Scanner(System.in);
int n,i;
System.out.print("Enter number of frame: "); n =
sc.nextInt();
System.out.println("n = " + n);
int a[] = new int[n];
dos.write(n);
for(i=0;i<n;i++){
a[i] = sc.nextInt();
}
for (i=1;i<=n;i++) {
System.out.println("Sending frame number " + i);
dos.write(a[i-1]);
} int temp =
dis.read();
System.out.println("");
for(i=temp;i<n;i++){
System.out.println("Sending frame number " + i);
dos.write(a[i]);
}
dos.close();
s1out.close();
s1.close();
}
}