@RestController
@RequestMapping(produces = "application/json")
public class SampleRestServerController {

    @GetMapping(path = "{sample1}")
    public ResponseEntity<String> getsample1(
            @PathVariable(name = "sample1") String sample1) {
        final JsonObject resp = Json.createObject().add("name", sample1).build();
        return ResponseEntity.ok(resp.toString());
    }

    @PostMapping(consumes="application/json")
    public ResponseEntity<String> postsample2(@RequestBody String payload){
        JsonObject body;
        try(InputStream is = new ByteArrayInputSTream(payload.getBytes())){
            JsonReader reader = Json.createReader(is);
            body = read.readObject();
        }catch(Exception e){
            body = Json.createObject().add("error", e.getMessage()).build();
            return ResponseEntity.internalServerError().body(body.toString());
        }
    }
}
