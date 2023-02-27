import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.http.HttpMethod;
import org.yaml.snakeyaml.Yaml;
import ru.loadgenerator.credentials.DataBaseCredentials;
import ru.loadgenerator.credentials.HttpCredentials;
import ru.loadgenerator.steps.HttpStep;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws Exception {
//        HttpCredentials httpCredentials = new HttpCredentials("https://animechan.vercel.app/api/random",
//                HttpMethod.GET,"Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:17.0) Gecko/20100101 Firefox/17.0",
//                "");
//        HttpStep httpStep1 = new HttpStep(httpCredentials,new HttpClient());
//        HttpStep httpStep2 = new HttpStep(httpCredentials,new HttpClient());
//        HttpStep httpStep3 = new HttpStep(httpCredentials,new HttpClient());
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        executorService.submit(httpStep1);
//        executorService.submit(httpStep2);
//        executorService.submit(httpStep3);
//        executorService.shutdown();

        InputStream inputStream = new FileInputStream(new File("src/main/resources/config.yaml"));

        Yaml yaml = new Yaml();
        Map<String, Object> data = yaml.load(inputStream);
        System.out.println(data);
        Object[] list = data.values().toArray();
        System.out.println(list.length);
        ArrayList<?> list1 = (ArrayList) list[0];
        System.out.println(list1.size());
        LinkedHashMap<String,String> linkedHashMap = (LinkedHashMap<String, String>) list1.get(0);
        System.out.println(linkedHashMap.toString());
        System.out.println(linkedHashMap.keySet());


    }
}
