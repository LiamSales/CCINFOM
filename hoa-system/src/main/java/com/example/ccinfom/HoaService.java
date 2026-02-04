import jakarta.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;

@Service
public class HoaService {

    private final HomeownerRepository homeownerRepository;

    public HoaService(HomeownerRepository homeownerRepository) {
        this.homeownerRepository = homeownerRepository;
    }

    @PostConstruct
    public void logDbInfo() throws Exception {
        try (Connection c = dataSource.getConnection()) {
            System.out.println("CONNECTED TO DB: " + c.getMetaData().getURL());
            System.out.println("DB USER: " + c.getMetaData().getUserName());
        }
    }

        public Homeowner save(Homeowner homeowner) {
        return homeownerRepository.save(homeowner);
    }

    public Homeowner getSampleHomeowner() {
        return homeownerRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Homeowner not found"));
    }
}
