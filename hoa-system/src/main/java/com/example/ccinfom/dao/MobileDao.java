@Repository
public class MobileDao {

    private final JdbcTemplate jdbcTemplate;

    public MobileDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> findByIndividualId(int individualid) {

        String sql = "SELECT mobilenum FROM mobile WHERE individualid = ?";

        return jdbcTemplate.queryForList(sql, String.class, individualid);
    }

    public int insert(String mobilenum, int individualid) {

        String sql = "INSERT INTO mobile (mobilenum, individualid) VALUES (?, ?)";

        return jdbcTemplate.update(sql, mobilenum, individualid);
    }

    public int deleteByIndividualId(int individualid) {

        String sql = "DELETE FROM mobile WHERE individualid = ?";

        return jdbcTemplate.update(sql, individualid);
    }
}
