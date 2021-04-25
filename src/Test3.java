import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Test3 {

  public static void main(String[] args) throws Exception {
    //
    URL url = new URL("http://localhost:8080/app/demo/get?name=t");
    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
    httpURLConnection.setRequestProperty("accept", "application/json");
    httpURLConnection.setRequestMethod("GET");
    try (BufferedReader br =
        new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()))) {
      System.out.println(new Gson().fromJson(br, DemoModel.class).toString());
    }
    httpURLConnection.disconnect();

    url = new URL("http://localhost:8080/app/demo/post");
    httpURLConnection = (HttpURLConnection) url.openConnection();
    httpURLConnection.setRequestProperty("accept", "application/json");
    httpURLConnection.setRequestProperty("Content-type", "application/json");
    httpURLConnection.setRequestMethod("POST");
    httpURLConnection.setDoOutput(true);
    try (OutputStream os = httpURLConnection.getOutputStream()) {
      os.write(new Gson().toJson(new DemoModel(89, 90)).getBytes(StandardCharsets.UTF_8));
    }
    try (BufferedReader br =
        new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()))) {
      System.out.println(new Gson().fromJson(br, DemoModel.class).toString());
    }
    httpURLConnection.disconnect();
  }

  static class DemoModel {
    int i;
    int j;

    public DemoModel(int i, int j) {
      this.i = i;
      this.j = j;
    }

    public int getI() {
      return i;
    }

    public DemoModel setI(int i) {
      this.i = i;
      return this;
    }

    public int getJ() {
      return j;
    }

    public DemoModel setJ(int j) {
      this.j = j;
      return this;
    }

    @Override
    public String toString() {
      return "DemoModel{" + "i=" + i + ", j=" + j + '}';
    }
  }
}
