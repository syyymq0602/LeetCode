import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class sf {
    public static void main(String[] args) throws InterruptedException, IOException {

        var filePath = "C:/Users/PPG12/Desktop/rec_Fwrn_0.dat";
        var in = new FileInputStream(filePath);
        var byteArrayOutputStream = new ByteArrayOutputStream();
        var bytes = new byte[1024];
        for (var i = -1; (i = in.read(bytes)) > -1; ) {
            byteArrayOutputStream.write(bytes, 0, i);
        }
        in.close();
        var res = byteArrayOutputStream.toByteArray();
        var len = res.length;
        var ave = len / 5;
        var bytes1 = new byte[ave];
        System.arraycopy(res, ave, bytes1, 0, ave);
        var dtos = new ResultReceiveDto[5];
        for (var i = 0; i < 5; i++) {
            System.arraycopy(res, i * ave, bytes1, 0, ave);
            System.out.println();
        }
        for (var i = 0; i < 5; i++) {
            System.arraycopy(res, i * ave, bytes1, 0, ave);
            dtos[i] = new ResultReceiveDto(
                    "3fa85f64-5717-4562-b3fc-2c963f66afa6",
                    i,
                    5,
                    bytes1,
                    new byte[0],
                    new byte[0],
                    new byte[0]);
        }

        BufferedReader reader = null;
        var strURL = "http://localhost:44359/api/cttsim/results/receive";
        try {
            var url = new URL(strURL);
            var conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setInstanceFollowRedirects(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.connect();
            var out = new OutputStreamWriter(conn.getOutputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ResultReceiveDto {
    public String ProjectId;
    public int Index;
    public int Total;
    public byte[] Fwr;
    public byte[] Wx;
    public byte[] Vehicle;
    public byte[] Motor;

    public ResultReceiveDto(String projectId, int index, int total,
                            byte[] fwr, byte[] wx, byte[] vehicle, byte[] motor) {
        ProjectId = projectId;
        Index = index;
        Total = total;
        Fwr = fwr;
        Wx = wx;
        Vehicle = vehicle;
        Motor = motor;
    }
}
