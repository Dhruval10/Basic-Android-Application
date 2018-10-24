package Database.model;

public class Info {

    public static final String TABLE_NAME = "Information";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SEM = "sem";
    public static final String COLUMN_BRANCH = "branch";


    private String id;
    private String name ;
    private String sem;
    private String branch;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " TEXT PRIMARY KEY,"
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_SEM + " TEXT,"
                    + COLUMN_BRANCH + " TEXT"
                    + ")";
    public Info() {
    }

    public Info(String id, String name, String sem, String branch) {
        this.id = id;
        this.name = name;
        this.sem = sem;
        this.branch = branch;
    }

    public String gId() {
        return id;
    }
    public String gName() {
        return name;
    }
    public String gSem() {
        return sem;
    }
    public String gBranch() {
        return branch;
    }


}
