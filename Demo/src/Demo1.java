/**
 * @ClassName Demo1
 * @Description
 * @Author Bruce
 * @Date 2020/12/23 下午7:07
 */


//public class MySQLiteHelper extends SQLiteOpenHelper {
//
//    public static final String DATABASE_NAME = "PackeagesOpenHelper.db";
//    public static final int DATABASE_VERSION = 1;
//    public static final String TABLE_NAME = "Packeages";
//
//
//    //调用父类构造器
//    public MySQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("create table if not exists ").append(TABLE_NAME);
//        sb.append("(").append("_id integer identity\\(1,1\\) primary key,");
//        sb.append("TrackID varchar\\(15\\),");
//        sb.append("PackeageFrom varchar\\(100\\),");
//        sb.append("PackeageTo varchar\\(100\\),");
//        sb.append("Weight integer)");
//        sqLiteDatabase.execSQL(sb.toString());
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        sqLiteDatabase.execSQL("drop table if exists " + TABLE_NAME);
//        this.onCreate(sqLiteDatabase);
//    }
//
//}
