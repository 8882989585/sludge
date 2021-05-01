package hackerrank.restcertification;

import com.google.gson.Gson;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

class Ques2 {

  class InnerTemp {
    String winner;

    public String getWinner() {
      return winner;
    }

    public InnerTemp setWinner(String winner) {
      this.winner = winner;
      return this;
    }
  }

  class Temp {
    List<InnerTemp> data;
  }

  public static int getWinnerTotalGoals(String competition, int year) {
    int totalGoals = 0;
    try {
      URL url =
          new URL(
              "https://jsonmock.hackerrank.com/api/football_competitions?name="
                  + URLEncoder.encode(competition, StandardCharsets.UTF_8.toString())
                  + "&year="
                  + year);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestProperty("accept", "application/json");
      connection.setRequestMethod("GET");
      BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      Temp temp = new Gson().fromJson(br, Temp.class);
//      String line;
//      StringBuilder sb = new StringBuilder();
//      while ((line = br.readLine()) != null) {
//        sb.append(line);
//      }
//      br.close();
      connection.disconnect();
      JSONParser jsonParser = new JSONParser();

//      String winner =
//          (String) ((JSONObject) ((JSONArray) jsonObject.get("data")).get(0)).get("winner");
//
//      int totalGoals = 0;
//      int counter = 1;
//      while (true) {
//        url =
//            new URL(
//                "https://jsonmock.hackerrank.com/api/football_matches?competition="
//                    + URLEncoder.encode(competition, StandardCharsets.UTF_8.toString())
//                    + "&team1="
//                    + winner
//                    + "&year="
//                    + year
//                    + "&page="
//                    + counter);
//        connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestProperty("accept", "application/json");
//        connection.setRequestMethod("GET");
//
//        br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//        sb = new StringBuilder();
//        while ((line = br.readLine()) != null) {
//          sb.append(line);
//        }
//        br.close();
//        connection.disconnect();
//        jsonObject = (JSONObject) jsonParser.parse(sb.toString());
//        JSONArray array = (JSONArray) jsonObject.get("data");
//        for (JSONObject object : (Iterable<JSONObject>) array) {
//          totalGoals += Integer.parseInt((String) object.get("team1goals"));
//        }
//        if (((Long) jsonObject.get("page")).longValue()
//            >= ((Long) jsonObject.get("total_pages")).longValue()) {
//          break;
//        }
//        counter++;
//      }
//
//      counter = 1;
//      while (true) {
//        url =
//            new URL(
//                "https://jsonmock.hackerrank.com/api/football_matches?competition="
//                    + URLEncoder.encode(competition, StandardCharsets.UTF_8.toString())
//                    + "&team2="
//                    + winner
//                    + "&year="
//                    + year
//                    + "&page="
//                    + counter);
//        connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestProperty("accept", "application/json");
//        connection.setRequestMethod("GET");
//        br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//        sb = new StringBuilder();
//        while ((line = br.readLine()) != null) {
//          sb.append(line);
//        }
//        br.close();
//        connection.disconnect();
//        jsonObject = (JSONObject) jsonParser.parse(sb.toString());
//        JSONArray array = (JSONArray) jsonObject.get("data");
//        for (JSONObject object : (Iterable<JSONObject>) array) {
//          totalGoals += Integer.parseInt((String) object.get("team2goals"));
//        }
//        if (((Long) jsonObject.get("page")).longValue()
//            >= ((Long) jsonObject.get("total_pages")).longValue()) {
//          break;
//        }
//        counter++;
//      }
      return totalGoals;
    } catch (Exception exception) {
      return -1;
    }
  }

  public static void main(String[] args) {
    System.out.println(Ques2.getWinnerTotalGoals("UEFA Champions League", 2011));
  }
}
