package hackerrank.restcertification;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class Ques1 {

  /*
   * Complete the 'getTotalGoals' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. STRING team
   *  2. INTEGER year
   */

  public static int getTotalGoals(String team, int year) {
    int totalGoals = 0;
    try {
      URL url =
          new URL(
              "https://jsonmock.hackerrank.com/api/football_matches?year="
                  + year
                  + "&team1="
                  + team
                  + "&page="
                  + 1);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestProperty("accept", "application/json");
      connection.setRequestMethod("GET");
      BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      StringBuilder sb = new StringBuilder();
      String inputLine;
      while ((inputLine = br.readLine()) != null) {
        sb.append(inputLine);
      }
      br.close();
      connection.disconnect();
      JSONParser parser = new JSONParser();
      JSONObject jsonObject = (JSONObject) parser.parse(sb.toString());
      Long totalPages = (Long) jsonObject.get("total_pages");
      long counter = 2L;
      if (totalPages != 0) {
        JSONArray arr = (JSONArray) jsonObject.get("data");
        for (JSONObject object : (Iterable<JSONObject>) arr) {
          totalGoals += Integer.parseInt((String) object.get("team1goals"));
        }
      }
      while (counter <= totalPages) {
        url =
            new URL(
                "https://jsonmock.hackerrank.com/api/football_matches?year="
                    + year
                    + "&team1="
                    + team
                    + "&page="
                    + counter);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        connection.setRequestMethod("GET");
        br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        sb = new StringBuilder();
        inputLine = null;
        while ((inputLine = br.readLine()) != null) {
          sb.append(inputLine);
        }
        br.close();
        connection.disconnect();
        jsonObject = (JSONObject) parser.parse(sb.toString());
        JSONArray arr = (JSONArray) jsonObject.get("data");
        for (JSONObject object : (Iterable<JSONObject>) arr) {
          totalGoals += Integer.parseInt((String) object.get("team1goals"));
        }
        counter++;
      }
      url =
          new URL(
              "https://jsonmock.hackerrank.com/api/football_matches?year="
                  + year
                  + "&team2="
                  + team
                  + "&page="
                  + 1);
      connection = (HttpURLConnection) url.openConnection();
      connection.setRequestProperty("accept", "application/json");
      connection.setRequestMethod("GET");
      br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      sb = new StringBuilder();
      inputLine = null;
      while ((inputLine = br.readLine()) != null) {
        sb.append(inputLine);
      }
      br.close();
      connection.disconnect();
      jsonObject = (JSONObject) parser.parse(sb.toString());
      totalPages = (Long) jsonObject.get("total_pages");
      counter = 2L;
      if (totalPages != 0) {
        JSONArray arr = (JSONArray) jsonObject.get("data");
        for (JSONObject object : (Iterable<JSONObject>) arr) {
          totalGoals += Integer.parseInt((String) object.get("team2goals"));
        }
      }
      while (counter <= totalPages) {
        url =
            new URL(
                "https://jsonmock.hackerrank.com/api/football_matches?year="
                    + year
                    + "&team2="
                    + team
                    + "&page="
                    + counter);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        connection.setRequestMethod("GET");
        br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        sb = new StringBuilder();
        inputLine = null;
        while ((inputLine = br.readLine()) != null) {
          sb.append(inputLine);
        }
        br.close();
        connection.disconnect();
        jsonObject = (JSONObject) parser.parse(sb.toString());
        JSONArray arr = (JSONArray) jsonObject.get("data");
        for (JSONObject object : (Iterable<JSONObject>) arr) {
          totalGoals += Integer.parseInt((String) object.get("team2goals"));
        }
        counter++;
      }
    } catch (Exception exp) {

    }
    return totalGoals;
  }

  public static void main(String[] args) {
    //    System.out.println(Result.getTotalGoals("Chelsea", 2014));
    System.out.println(Ques1.getTotalGoals("Barcelona", 2011));
  }
}
