package vn.coderschool.thorgroup.travelling.service;

import android.os.AsyncTask;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by tanlnm on 4/20/2016.
 */
public class HttpUtils extends AsyncTask<String, String, Void> {
    private static final int TIME_OUT = 20000;
    private IResultListener mCallback = null;
    private File mFile = null;
    private String mJson = null;
    private Exception mException = null;

    public HttpUtils(File file, IResultListener callback) {
        mCallback = callback;
        mFile = file;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(String... params) {
        if (mFile != null) {
            uploadFileHttp(params);

        } else {
            callHttp(params);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void v) {
        super.onPostExecute(v);
        String json = "{\n" +
                "posts: [\n" +
                "{\n" +
                "user: {\n" +
                "username: \"0.5995627162815309\",\n" +
                "profile_picture_url: \"https://www.sparklabs.com/forum/styles/comboot/theme/images/default_avatar.jpg\",\n" +
                "id: 96,\n" +
                "full_name: \"John Doe 8\",\n" +
                "cover_picture_url: \"https://unsplash.com/photos/W2KEyYAAvU4\"\n" +
                "},\n" +
                "status: \"Status 1\",\n" +
                "reaction: true,\n" +
                "longitude: 106.708019,\n" +
                "latitude: 10.76174,\n" +
                "image_url: \"http://migrationology.com/wp-content/uploads/2014/12/best_banh_mi_saigon_vietnam-1024x682.jpg\",\n" +
                "id: 840,\n" +
                "created_at: 1460289122,\n" +
                "category: \"place of interest\"\n" +
                "},\n" +
                "{\n" +
                "user: {\n" +
                "username: \"0.26513154059818156\",\n" +
                "profile_picture_url: \"https://www.sparklabs.com/forum/styles/comboot/theme/images/default_avatar.jpg\",\n" +
                "id: 75,\n" +
                "full_name: \"John Doe 27\",\n" +
                "cover_picture_url: \"https://unsplash.com/photos/4LYbjO_hDDw\"\n" +
                "},\n" +
                "status: \"Status 2\",\n" +
                "reaction: true,\n" +
                "longitude: 106.706718,\n" +
                "latitude: 10.789813,\n" +
                "image_url: \"http://www.shaozhionthenet.com/wp-content/gallery/saigon-opera-house-ho-chi-minh-city-vietnam-july-2014/P7110003.jpg\",\n" +
                "id: 841,\n" +
                "created_at: 1460289122,\n" +
                "category: \"place of interest\"\n" +
                "},\n" +
                "{\n" +
                "user: {\n" +
                "username: \"0.876101796989839\",\n" +
                "profile_picture_url: \"https://www.sparklabs.com/forum/styles/comboot/theme/images/default_avatar.jpg\",\n" +
                "id: 46,\n" +
                "full_name: \"John Doe 38\",\n" +
                "cover_picture_url: \"https://unsplash.com/photos/SK3uHKx5nCU\"\n" +
                "},\n" +
                "status: \"Status 3\",\n" +
                "reaction: true,\n" +
                "longitude: 106.704605,\n" +
                "latitude: 10.786353,\n" +
                "image_url: \"http://www.deluxegrouptours.vn/wp-content/uploads/2015/03/Notre-Dame-Cathedral-ho-chi-minh-city-tour-half-day4.jpg\",\n" +
                "id: 842,\n" +
                "created_at: 1460289122,\n" +
                "category: \"food\"\n" +
                "},\n" +
                "{\n" +
                "user: {\n" +
                "username: \"0.3169853123749553\",\n" +
                "profile_picture_url: \"https://www.sparklabs.com/forum/styles/comboot/theme/images/default_avatar.jpg\",\n" +
                "id: 93,\n" +
                "full_name: \"John Doe 5\",\n" +
                "cover_picture_url: \"https://unsplash.com/photos/4LYbjO_hDDw\"\n" +
                "},\n" +
                "status: \"Status 4\",\n" +
                "reaction: true,\n" +
                "longitude: 106.664045,\n" +
                "latitude: 10.780187,\n" +
                "image_url: \"http://farm1.static.flickr.com/157/428016237_77562aaf32.jpg\",\n" +
                "id: 843,\n" +
                "created_at: 1460289122,\n" +
                "category: \"food\"\n" +
                "},\n" +
                "{\n" +
                "user: {\n" +
                "username: \"0.20275679608861363\",\n" +
                "profile_picture_url: \"https://www.sparklabs.com/forum/styles/comboot/theme/images/default_avatar.jpg\",\n" +
                "id: 29,\n" +
                "full_name: \"John Doe 21\",\n" +
                "cover_picture_url: \"https://unsplash.com/photos/4LYbjO_hDDw\"\n" +
                "},\n" +
                "status: \"Status 5\",\n" +
                "reaction: true,\n" +
                "longitude: 106.735194,\n" +
                "latitude: 10.786933,\n" +
                "image_url: \"http://www.surfsidebackpackers.com.au/wp-content/uploads/2015/08/coogee-beach-sydney.jpg\",\n" +
                "id: 844,\n" +
                "created_at: 1460289122,\n" +
                "category: \"place of interest\"\n" +
                "},\n" +
                "{\n" +
                "user: {\n" +
                "username: \"0.3169853123749553\",\n" +
                "profile_picture_url: \"https://www.sparklabs.com/forum/styles/comboot/theme/images/default_avatar.jpg\",\n" +
                "id: 93,\n" +
                "full_name: \"John Doe 5\",\n" +
                "cover_picture_url: \"https://unsplash.com/photos/W2KEyYAAvU4\"\n" +
                "},\n" +
                "status: \"Status 6\",\n" +
                "reaction: true,\n" +
                "longitude: 106.690527,\n" +
                "latitude: 10.765432,\n" +
                "image_url: \"http://www.australia.com/content/australia/en/places/nsw/nsw-bondi-bronte/_jcr_content/image.adapt.985.medium.jpg\",\n" +
                "id: 845,\n" +
                "created_at: 1460289122,\n" +
                "category: \"food\"\n" +
                "},\n" +
                "{\n" +
                "user: {\n" +
                "username: \"0.4175003662086503\",\n" +
                "profile_picture_url: \"https://www.sparklabs.com/forum/styles/comboot/theme/images/default_avatar.jpg\",\n" +
                "id: 97,\n" +
                "full_name: \"John Doe 9\",\n" +
                "cover_picture_url: \"https://unsplash.com/photos/4LYbjO_hDDw\"\n" +
                "},\n" +
                "status: \"Status 7\",\n" +
                "reaction: true,\n" +
                "longitude: 106.690881,\n" +
                "latitude: 10.793249,\n" +
                "image_url: \"http://www.sydney.visitorsbureau.com.au/tours/aat-kings-t3/manly-beach-1673-1.jpg\",\n" +
                "id: 846,\n" +
                "created_at: 1460289122,\n" +
                "category: \"accommodation\"\n" +
                "},\n" +
                "{\n" +
                "user: {\n" +
                "username: \"0.05430006206638027\",\n" +
                "profile_picture_url: \"https://www.sparklabs.com/forum/styles/comboot/theme/images/default_avatar.jpg\",\n" +
                "id: 40,\n" +
                "full_name: \"John Doe 32\",\n" +
                "cover_picture_url: \"https://unsplash.com/photos/W2KEyYAAvU4\"\n" +
                "},\n" +
                "status: \"Status 8\",\n" +
                "reaction: true,\n" +
                "longitude: 106.6998,\n" +
                "latitude: 10.781295,\n" +
                "image_url: \"http://migrationology.com/wp-content/uploads/2014/12/best_banh_mi_saigon_vietnam-1024x682.jpg\",\n" +
                "id: 847,\n" +
                "created_at: 1460289122,\n" +
                "category: \"accommodation\"\n" +
                "},\n" +
                "{\n" +
                "user: {\n" +
                "username: \"0.989293905914232\",\n" +
                "profile_picture_url: \"https://www.sparklabs.com/forum/styles/comboot/theme/images/default_avatar.jpg\",\n" +
                "id: 26,\n" +
                "full_name: \"John Doe 18\",\n" +
                "cover_picture_url: \"https://unsplash.com/photos/W2KEyYAAvU4\"\n" +
                "},\n" +
                "status: \"Status 9\",\n" +
                "reaction: true,\n" +
                "longitude: 106.734203,\n" +
                "latitude: 10.77685,\n" +
                "image_url: \"http://migrationology.com/wp-content/uploads/2014/12/best_banh_mi_saigon_vietnam-1024x682.jpg\",\n" +
                "id: 848,\n" +
                "created_at: 1460289122,\n" +
                "category: \"place of interest\"\n" +
                "},\n" +
                "{\n" +
                "user: {\n" +
                "username: \"0.13466015727521152\",\n" +
                "profile_picture_url: \"https://www.sparklabs.com/forum/styles/comboot/theme/images/default_avatar.jpg\",\n" +
                "id: 81,\n" +
                "full_name: \"John Doe 33\",\n" +
                "cover_picture_url: \"https://unsplash.com/photos/9j1hXX8jO1I\"\n" +
                "},\n" +
                "status: \"Status 10\",\n" +
                "reaction: true,\n" +
                "longitude: 106.685918,\n" +
                "latitude: 10.772203,\n" +
                "image_url: \"http://migrationology.com/wp-content/uploads/2014/12/best_banh_mi_saigon_vietnam-1024x682.jpg\",\n" +
                "id: 849,\n" +
                "created_at: 1460289122,\n" +
                "category: \"food\"\n" +
                "},\n" +
                "{\n" +
                "user: {\n" +
                "username: \"0.47577245929350576\",\n" +
                "profile_picture_url: \"https://www.sparklabs.com/forum/styles/comboot/theme/images/default_avatar.jpg\",\n" +
                "id: 21,\n" +
                "full_name: \"John Doe 13\",\n" +
                "cover_picture_url: \"https://unsplash.com/photos/4LYbjO_hDDw\"\n" +
                "},\n" +
                "status: \"Status 11\",\n" +
                "reaction: true,\n" +
                "longitude: 106.701289,\n" +
                "latitude: 10.79538,\n" +
                "image_url: \"http://migrationology.com/wp-content/uploads/2014/12/best_banh_mi_saigon_vietnam-1024x682.jpg\",\n" +
                "id: 850,\n" +
                "created_at: 1460289122,\n" +
                "category: \"place of interest\"\n" +
                "},\n" +
                "{\n" +
                "user: {\n" +
                "username: \"0.400961456281661\",\n" +
                "profile_picture_url: \"https://www.sparklabs.com/forum/styles/comboot/theme/images/default_avatar.jpg\",\n" +
                "id: 22,\n" +
                "full_name: \"John Doe 14\",\n" +
                "cover_picture_url: \"https://unsplash.com/photos/SK3uHKx5nCU\"\n" +
                "},\n" +
                "status: \"Status 12\",\n" +
                "reaction: true,\n" +
                "longitude: 106.737288,\n" +
                "latitude: 10.794638,\n" +
                "image_url: \"http://migrationology.com/wp-content/uploads/2014/12/best_banh_mi_saigon_vietnam-1024x682.jpg\",\n" +
                "id: 851,\n" +
                "created_at: 1460289123,\n" +
                "category: \"accommodation\"\n" +
                "},\n" +
                "{\n" +
                "user: {\n" +
                "username: \"0.9410461712895581\",\n" +
                "profile_picture_url: \"https://www.sparklabs.com/forum/styles/comboot/theme/images/default_avatar.jpg\",\n" +
                "id: 110,\n" +
                "full_name: \"John Doe 22\",\n" +
                "cover_picture_url: \"https://unsplash.com/photos/4LYbjO_hDDw\"\n" +
                "},\n" +
                "status: \"Status 13\",\n" +
                "reaction: true,\n" +
                "longitude: 106.693883,\n" +
                "latitude: 10.769527,\n" +
                "image_url: \"http://migrationology.com/wp-content/uploads/2014/12/best_banh_mi_saigon_vietnam-1024x682.jpg\",\n" +
                "id: 852,\n" +
                "created_at: 1460289123,\n" +
                "category: \"place of interest\"\n" +
                "}]}";
        if (TextUtils.isEmpty(mJson) || mException != null) {
            mCallback.onFail(mException);

        } else {
            mCallback.onSuccess(json);
        }
    }

    /*
     * @param params[0] : url
     * @param params[1] : method
     * @param params[2] : header
     * @param params[3] : header value
     */
    private void uploadFileHttp(String... params) {
        String lineEnd = "\r\n";
        String twoHyphens = "--";
        String boundary = "*****";
        HttpURLConnection conn = null;
        DataOutputStream dos;
        int bytesRead, bytesAvailable, bufferSize;
        byte[] buffer;
        int maxBufferSize = 1024 * 1024;

        try {
            // open a URL connection to the Servlet
            URL url = new URL(params[0]);

            // Open a HTTP connection to the URL
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true); // Allow Inputs
            conn.setDoOutput(true); // Allow Outputs
            conn.setUseCaches(false); // Don't use a Cached Copy
            conn.setConnectTimeout(TIME_OUT);
            conn.setReadTimeout(TIME_OUT);
            conn.setRequestMethod(params[1]);
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("ENCTYPE", "multipart/form-data");
            conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
            conn.setRequestProperty("image", mFile.getName());

            dos = new DataOutputStream(conn.getOutputStream());
            dos.writeBytes(twoHyphens + boundary + lineEnd);
            dos.writeBytes("Content-Disposition: form-data; name=avatar;filename=" + mFile.getName() + "" + lineEnd);

            dos.writeBytes(lineEnd);

            // create a buffer of maximum size
            FileInputStream fileInputStream = new FileInputStream(mFile);
            bytesAvailable = fileInputStream.available();

            bufferSize = Math.min(bytesAvailable, maxBufferSize);
            buffer = new byte[bufferSize];

            // read file and write it into form...
            bytesRead = fileInputStream.read(buffer, 0, bufferSize);

            while (bytesRead > 0) {
                dos.write(buffer, 0, bufferSize);
                bytesAvailable = fileInputStream.available();
                bufferSize = Math.min(bytesAvailable, maxBufferSize);
                bytesRead = fileInputStream.read(buffer, 0, bufferSize);
            }

            // send multipart form data necesssary after file data...
            dos.writeBytes(lineEnd);
            dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

            // Responses from the server (code and message)
            int serverResponseCode = conn.getResponseCode();
            String serverResponseMessage = conn.getResponseMessage();
            if (serverResponseCode != 200) {
                String errorMessage = String.format("Received the response code %d from the URL %s", serverResponseCode, url);
                errorMessage += lineEnd + serverResponseMessage;
                mException = new UploadFileException(errorMessage);
            }

            // Read the response
            InputStream is = conn.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            buffer = new byte[1024];
            while ((bytesRead = is.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            byte[] bytesReceived = baos.toByteArray();
            baos.close();
            is.close();
            fileInputStream.close();
            mJson = new String(bytesReceived);

        } catch (Exception e) {
            mException = e;

        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    /*
     * @param params[0] : url
     * @param params[1] : method
     * @param params[2] : header
     * @param params[3] : header value
     */
    private void callHttp(String... params) {
        try {
            URL url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(params[1]);

            if (!TextUtils.isEmpty(params[2])) {
                connection.setRequestProperty(params[2], params[3]);
            }

            connection.setConnectTimeout(TIME_OUT);
            connection.setReadTimeout(TIME_OUT);
            connection.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            int approxStringLength = connection.getContentLength();

            StringBuilder b;
            if (approxStringLength > 0)
                b = new StringBuilder(approxStringLength);
            else
                b = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) b.append(line);

            mJson = b.toString();
            connection.disconnect();
        } catch (Exception e) {
            mException = e;
        }
    }

    public interface IResultListener {
        void onSuccess(String json);

        void onFail(Exception e);
    }
}
