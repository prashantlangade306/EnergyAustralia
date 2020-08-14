package com.energyaustralia.client;

import com.energyaustralia.model.Festival;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
public class CallRestService implements CommandLineRunner {

    public static void callRestService(){
        RestTemplate restTemplate = new RestTemplate();
        Set<String> recordLabels = new HashSet<>();

        //Consume API response
        ResponseEntity<List<Festival>> rateResponse =
                restTemplate.exchange("http://eacodingtest.digital.energyaustralia.com.au/api/v1/festivals",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Festival>>() {
                        });
        List<Festival> festivalList = rateResponse.getBody();

        //Get unique record labels from the list.
        festivalList.forEach(festival -> {
                    festival.getBands().forEach(band ->
                            recordLabels.add(band.getRecordLabel())
                    );
        });

        Map<String, List<Map<String, String>>> recordLablesToBandNameListMap = new HashMap<>();

        //Get recordLabel to band name list map.
        festivalList.forEach(festival -> {
            festival.getBands().forEach(band -> {
                            if(recordLabels.contains(band.getRecordLabel())) {
                                if(recordLablesToBandNameListMap.containsKey(band.getRecordLabel())){
                                    List<Map<String, String>> bandNamesList = recordLablesToBandNameListMap.get(band.getRecordLabel());
                                    Map<String, String> map = new HashMap<>();
                                    map.put(band.getName(), festival.getName());
                                    if(bandNamesList != null){
                                        bandNamesList.add(map);
                                    }
                                } else {
                                    List<Map<String, String>> newBandList = new ArrayList<>();
                                    Map<String, String> map = new HashMap<>();
                                    map.put(band.getName(), festival.getName());
                                    newBandList.add(map);
                                    recordLablesToBandNameListMap.put(band.getRecordLabel(), newBandList);
                                }
                            }
                    }
            );
        });


        //Sor the map keys
        Map<String, List<Map<String, String>>> sortedMap = new HashMap<>();
        recordLablesToBandNameListMap.entrySet()
                .stream()
                .filter(x -> x.getKey()!=null)
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x ->
                        sortedMap.put(x.getKey(), x.getValue())
                );


        //Print the map in the required order
        sortedMap.entrySet().stream().forEach( (e) -> {
                System.out.println(e.getKey());
                List<Map<String, String>> mapList = e.getValue();
                if(mapList != null){
                    mapList.forEach( map ->
                            map.entrySet().stream().forEach(e1 ->
                                    System.out.println(" "+e1.getKey()+ "\n   " +e1.getValue())
                            )

                    );
                }
            }
        );
    }


    @Override
    public void run(String... args) throws Exception {
        callRestService();
    }
}
