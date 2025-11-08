package assignments.Ex0;
import java.util.UUID;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
public class Ex0_Report {
    public static void main(String[] args) {
        long id = 1234;
        int ex = 0;
        String data = "Ex0";
        long time = System.currentTimeMillis();
        String s = getUUID(time,ex,id,data);
        boolean auth1 = isValid1(s);
        boolean auth2 = isValid2(s);
        System.out.println(auth1+" "+auth2);
    }
    public static boolean isValid1(String s1){
        String[] wo = s1.split(",");
        String uuid1 = wo[4];

        String uuid1a = getUUIDMAC();
        boolean ans = false;
        if(uuid1a.equals(uuid1)) {
            ans = true;
        }
        return ans;
    }
    public static boolean isValid2(String s1){
        String[] wo = s1.split(",");
        long time = Long.parseLong(wo[0]);
        int ex = Integer.parseInt(wo[1]);
        long id = Long.parseLong(wo[2]);
        String data = wo[3];
        String uuid1 = wo[4];
        String s = getUUID(time,ex,id,data);
        boolean ans = false;
        if(s1.equals(s)) {
            ans = true;
        }
        return ans;
    }
    public static String getUUID(long time, int Ex, long ID, String data) {
     //   byte[] bb = {1,2,3,4,5,6,7,8,9};
        String code = getMac();
        UUID uuid1 = UUID.nameUUIDFromBytes(code.getBytes());
        code = time+Ex+ID+data+uuid1;
        byte[] bytes = code.getBytes();
        UUID uuid2 = UUID.nameUUIDFromBytes(bytes);
       // String ans = uuid2.toString();
        String ans = time+","+Ex+","+ID+","+data+","+uuid1+","+uuid2;
        return ans;
    }
    public static String getUUID(int Ex, long ID, String data, String code) {
        //   byte[] bb = {1,2,3,4,5,6,7,8,9};
       // String code = getMac();
        code += Ex+ID+data+"6666";
        byte[] bytes = code.getBytes();

        UUID uuid = UUID.nameUUIDFromBytes(bytes);
        String ans = uuid.toString();
        ans = ""+Ex+","+ID+","+data+","+ans;
        return ans;
    }
    public static String getUUIDMAC() {
        String code = getMac();
        byte[] bytes = code.getBytes();
        UUID uuid = UUID.nameUUIDFromBytes(bytes);
        String ans = uuid.toString();
        return ans;
    }
    private static String getMac() {
        String ans = "66:66:66:66:66:66";
        try {
            // Get all network interfaces on the system
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            // Iterate through each network interface
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface ni = networkInterfaces.nextElement();
                // Get the hardware address (MAC address) as a byte array
                byte[] mac = ni.getHardwareAddress();
                // If a MAC address exists for this interface
                if (mac != null) {
                    // Build the MAC address string in hexadecimal format

                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < mac.length; i++) {
                        sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                    }
                    ans += sb.toString();
                //    System.out.println("Interface Name: " + ni.getDisplayName() + ", MAC Address: " + sb.toString());
                }
            }
        } catch (SocketException e) {;
       //     System.err.println("Error accessing network interfaces: " + e.getMessage());
        }
        return ans;
    }
}
