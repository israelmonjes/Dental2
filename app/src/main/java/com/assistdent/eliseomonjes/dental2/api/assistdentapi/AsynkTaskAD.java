package com.assistdent.eliseomonjes.dental2.api.assistdentapi;

import android.app.Activity;
import android.os.AsyncTask;

import com.assistdent.eliseomonjes.dental2.api.models.ClientService;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsynkTaskAD extends AsyncTask<Void, Void, JSONObject> {


    public static final String SERVICE_TYPE = "service.Type";
    public static final String TYPE_GET = "service.Type.Get";
    public static final String TYPE_POST = "service.Type.Post";
    private static final String GET = "GET";
    private static final String POST = "POST";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON = "application/json";

    private String model;

    private ClientService serviceInterface;


    private Activity activity;
    private String url;
    private String requestType;

    public AsynkTaskAD(Activity activity) {
        this.activity = activity;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setModel(String model) {
        this.model = model;
    }


    private JSONObject post() {

        StringBuilder stringBuilder = null;
        URL url = null;
        try {
            url = new URL(this.url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
        try {
            assert null != url;
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(20000);
            //connection.setConnectTimeout(2000);
            connection.setRequestMethod(POST);

            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestProperty(CONTENT_TYPE, APPLICATION_JSON);
            if (model != null) {
                connection.getOutputStream().write(model.getBytes("UTF-8"));
            }

            InputStream inputStream = getStream(connection);

            if (inputStream == null) {
                return null;
            }

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 8);
            String line;
            stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            return new JSONObject(stringBuilder.toString());

        } catch (java.net.SocketTimeoutException e) {
            e.printStackTrace();
            return null;

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }


        return null;
    }


    private JSONObject getService() {
        StringBuilder stringBuilder = null;
        try {
            URL url = new URL(this.url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(GET);
            connection.setDoInput(true);

            connection.setRequestProperty(CONTENT_TYPE, APPLICATION_JSON);
            connection.setConnectTimeout(20000);
            connection.setReadTimeout(20000);

            connection.getResponseCode();

            InputStream inputStream = getStream(connection);


            if (inputStream == null) {
                return null;
            }

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 8);
            String line;
            stringBuilder = new StringBuilder();

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            return new JSONObject(stringBuilder.toString());
            //}
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


    private InputStream getStream(HttpURLConnection connection) {
        try {
            return connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection.getErrorStream();
    }


    @Override
    protected JSONObject doInBackground(Void... params) {
        switch (requestType) {
            case TYPE_GET:
                return getService();
            case TYPE_POST:
                return post();
            default:
                return null;
        }
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);

   /**     if (jsonObject == null) {
            //serviceInterface.onFailedServerConnection();
            return;
        }

        ResponseParser parser = new ResponseParser(jsonObject);

        if (parser.hasError()) {
            serviceInterface.onErrorResponse(
                    parser.getResponseCode(),
                    parser.getMessage()
            );


            if (parser.needsLogout()) {
                GeneralUtils.logout(activity, parser.getMessage());
                return;
            }

            return;
        }

        serviceInterface.onSuccessResponse(
                parser.getResponse()
        );*/
    }


}
