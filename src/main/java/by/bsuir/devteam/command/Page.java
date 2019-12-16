package by.bsuir.devteam.command;

public class Page {

    /**
     * Common pages.
     */
    public static final String MAIN_PAGE_PATH = "/pages/common/main.jsp";
    public static final String DEVELOPERS_PAGE_PATH  = "/pages/common/developers.jsp";
    public static final String TESTERS_PAGE_PATH  = "/pages/common/testers.jsp";
    public static final String BUSINESS_ANALYSTS_PAGE_PATH  = "/pages/common/businessAnalysts.jsp";
    public static final String TL_SP_PAGE_PATH = "/pages/common/TLSP.jsp";


    private final String pageUrl;
    private final boolean isRedirect;

    /**
     * Instantiates a new Page.
     */

    public Page(String pageUrl, boolean isRedirect) {
        this.pageUrl = pageUrl;
        this.isRedirect = isRedirect;
    }

    public String getPageUrl() {
        return pageUrl;
    }


    public boolean isRedirect() {
        return isRedirect;
    }

}
