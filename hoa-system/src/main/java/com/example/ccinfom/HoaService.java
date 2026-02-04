import jakarta.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;

@Service
public class HoaService {

    private final HomeownerRepository repository;
    private final DataSource dataSource;

    public HoaService(HomeownerRepository repository, DataSource dataSource) {
        this.repository = repository;
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void logDbInfo() throws Exception {
        try (Connection c = dataSource.getConnection()) {
            System.out.println("CONNECTED TO DB: " + c.getMetaData().getURL());
            System.out.println("DB USER: " + c.getMetaData().getUserName());
        }
    }

    public Homeowner getSampleHomeowner() {
        return repository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Homeowner not found"));
    }
}
