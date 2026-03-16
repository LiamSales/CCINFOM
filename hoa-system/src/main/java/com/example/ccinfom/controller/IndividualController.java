@RestController
@RequestMapping("/individuals")
public class IndividualController {

    private final IndividualService individualService;

    public IndividualController(IndividualService individualService) {
        this.individualService = individualService;
    }

    @GetMapping
    public List<Individual> getAllIndividuals() {
        return individualService.getAllIndividuals();
    }

    @GetMapping("/{id}")
    public Individual getIndividual(@PathVariable int id) {
        return individualService.getIndividualById(id);
    }

    @PostMapping
    public int createIndividual(@RequestBody Individual individual) {
        return individualService.createIndividual(individual);
    }
}
