package ru.practicum.explorewithme.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.util.DefaultUriBuilderFactory;
import ru.practicum.explorewithme.client.BaseClient;
import ru.practicum.explorewithme.event.dto.StatsDto;
import ru.practicum.explorewithme.event.model.NewEventHit;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class EventClient extends BaseClient {
//    private static final String API_PREFIX = "/bookings";

    @Autowired
//    public EventClient(@Value("http://localhost:9090") String serverUrl, RestTemplateBuilder builder) {
    public EventClient(@Value("${explore-with-me-stats.url}") String serverUrl, RestTemplateBuilder builder) {
        super(
                builder
//                        .uriTemplateHandler(new DefaultUriBuilderFactory(serverUrl + API_PREFIX))
                        .uriTemplateHandler(new DefaultUriBuilderFactory(serverUrl))
                        .requestFactory(HttpComponentsClientHttpRequestFactory::new)
                        .build()
        );
    }

    public void hit(NewEventHit newEventHit) {
        post("/hit", newEventHit);
    }

    public StatsDto getStats(LocalDateTime start, LocalDateTime end, List<String> uris, boolean unique) {
        Map<String, Object> parameters = Map.of(
                "start", start.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                "end", end.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                "uris", uris,
                "unique", unique
        );
        ResponseEntity<Object> entity = get("/stats?start={start}&end={end}&uris={uris}&unique={unique}", parameters);
        System.out.println(entity);
        @SuppressWarnings("unchecked")
        List<LinkedHashMap<String, Object>> list = (List<LinkedHashMap<String, Object>>) entity.getBody();
        LinkedHashMap<String, Object> linkedHashMap = list.get(0);
        return new StatsDto((String) linkedHashMap.get("app"), (String) linkedHashMap.get("uri"), (int) linkedHashMap.get("hits"));
    }
}
