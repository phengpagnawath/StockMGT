package com.dgb.utils;

public class Constants {
    public final static String URL = "jdbc:postgresql://localhost:5432/stockmgt";
    public final static String USER = "postgres";
    public final static String PASSWORD = "12345";

    public final static String FILE_IO = "pageRow.txt";

    public final static String WELCOME = "Welcome to Stock Management system";


    public final static String DGB_ROW1 = "  _____    _____ ____   ";
    public final static String DGB_ROW2 = " |  __ \\ / ____|  _ \\ ";
    public final static String DGB_ROW3 = " | |  | | |  __| |_) |";
    public final static String DGB_ROW4 = " | |  | | | |_ |  _ < ";
    public final static String DGB_ROW5 = " | |__| | |__| | |_) |";
    public final static String DGB_ROW6 = " |_____/ \\_____|____/ ";
    public final static String LINE = "*--------------------------------------------------------------------------------" +
            "---------------------------------------------------------------------*";


    public final static String INPUT_WRONG_TYPE = "Sorry your input is wrong type..!";
    public final static String ID = "ID";
    public final static String NAME = "Product's Name";
    public final static String QTY = "Quantity";
    public final static String UNIT_PRICE = "Unit Price";
    public final static String IMP_DATE = "Import Date";
    public final static String[] PRODUCT_HEADER={"ID","Product's Name","Quantity","Unit Price","Import Date"};
    public final static String INSERT_DATA_SUCCESS="Your product insert successful..!";
    public final static String PRODUCT_UPDATED="Your product has been update ..! ";

    public final static String UPDATE_PRODUCT="Updating Product";
    public final static String INSERT_DATA_FAIL="Your product insert fail..!";
    public final static String UPDATE_DATA_FAIL="Your product update fail..!";

    public final static String PRESS_KEY_ENTER="Press key \"Enter\" to continues ....";
    public final static String INPUT_INCORRECT="You input wrong data ...!";
    public final static String PRODUCT_NOT_FOUND="Your product's ID doesn't exist ..!";
    public final static String PRODUCT_IS_FOUND="Your product info is Above...!";


    public final static String MENU_VIEW1 = "(*)Display | (W)rite | (R)ead | (U)pdate | (F)irst | (P)revious | (N)ext |" +
            "(L)ast";
    public final static String MENU_VIEW2 = "(S)earch | (G)o to | Set r(o)w | (H)elp | (E)xit";
    public final static String COMMAND = "Command -> ";
    public final static String SET_PAGE_ROW = "Set page row -> ";
    public final static String PRODUCT_ID = "Product's ID : ";
    public final static String PRODUCT_NAME = "Product's name : ";
    public final static String PRODUCT_PRICE = "Product's price : ";
    public final static String PRODUCT_QTY = "Product's quantity : ";
    public final static String ENTER="Enter ";
    public final static String PAGE_NUMBER="page number -> ";

    public final static String ALREADY_FIRST_PAGE="You already on first page!";
    public final static String ALREADY_LAST_PAGE="You already on last page!";
    public final static String OUT_OF_LIMIT="This page is out...!";
    public final static String PAGE_CANNOT_DISPLAY="This page cannot display ...!";
    public final static String PRODUCT_NAME_NOT_FOUND="This product doesn't exist ..!";
}
