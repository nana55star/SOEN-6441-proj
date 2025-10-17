package controllers;

import play.mvc.*;
import play.libs.Json;
import services.NewsService;

public class SearchController extends Controller {

    private final NewsService newsService = new NewsService();

    public Result index() {
        return ok(views.html.index.render("NotiLytics"));
    }

    public Result search(String q) {
        try {
            var resp = newsService.searchNewsWithStatus(q); // see service below
            return status(resp.status, resp.body).as("application/json");
        } catch (Exception e) {
            return internalServerError("Server error: " + e.getMessage());
        }
    }
}
