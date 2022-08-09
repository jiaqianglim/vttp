public class SampleRestClient {

    public void getexample() {
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = template.getForEntity(url, String.class);
        System.out.printf("Status code: %d\n", resp.getStatusCodeValue());
        System.out.printf("Payload: %s\n", resp.getBody());
    }

    public void getwithexchangeexample() {

        // Optional url with query parameters
        String url = UrlComponentBuilder
                .fromUriString(url)
                .queryParam("field1", "value1")
                .toUriString();

        RequestEntity<String> req = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = template.exchange(req, String.class);

        try (InputStream is = new ByteArrayInputStream(resp.getBody().getBytes())) {
            JsonReader reader = Json.createReader();
            JsonObject data = reader.readObject();
        }
    }

    public void posturlencodedform(){
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>(); 
        form.add("field1", "value1"); 
        form.add("field2", "value2"); 
        RequestEntity<MultiValueMap<String, String>> req = RequestEntity 
        .post(url) 
        .contentType(MediaType.APPLICATION_FORM_URLENCODED) 
        .body(form, MultiValueMap<String, String>.class);

        RestTemplate template = new RestTemplate(); 
        ResponseEntity<String> resp = template.exchange(req, String.class);

        try(InputStream is = new ByteArrayInputStream(resp.getBody().getBytes())){
            JsonReader reader = Json.createReader();
            JsonObject data = reader.readObject();
        }
    }

    public void postjson(){
        JsonObject json = Json.createObject().add("field1", "value1").build();

        RequestEntity<String> req = RequestEntity
        .post(url)
        .contentType(MediaType.APPLICATION_JSON)
        .headers("Accept", MediaType.APPLICATION_JSON)
        .body(json.toString(), String.class);

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> rest = template.exchange(req, String.class);

        try(InputStream is = new ByteArrayInputStream(resp.getBody().getBytes())){
            JsonReader reader = Json.createReader();
            JsonObject data = reader.readObject();
    }



}
