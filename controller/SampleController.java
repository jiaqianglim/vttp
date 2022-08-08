@Controller
@RequestMapping(path = "/")
public class SampleController {
    @GetMapping
    public String samplepage(
            @RequestParam(required = true) String city,
            @RequestParam(name = "units", defaultValue = "metrics") String units,
            Model model) {
        return "index";
    }

    @GetMapping
    public String samplepage2(
            @RequestParam MultiValueMap<String, String> queryParams,
            Model model) {
        final Collection<String> cities = (Collection<String>) queryParams.get("cities");
        final String units = queryParam.getFirst("units");
        return "index";
    }

    @GetMapping("{city}")
    public String samplepage3(
            @PathVariable(name = "city", required = true) String city,
            @RequestParam(name = "units", defaultValue = "metrics") String units,
            Model model) {
        return "index";
    }

    @PostMapping(consumes = "application/x-www-form-urlencoded", produces = "text/html")
    public String samplepage4(@ModelAttribute User user, Model model) {
        return "index";
    }

    @PostMapping(consumes = "application/x-www-form-urlencoded", produces = "text/html")
    public String samplepage4(@RequestBody MultiValueMap<String, String> form, Model model) {
        String name = form.getFirst("name");
        String email = form.getFirst("email");
        return "index";
    }

}
