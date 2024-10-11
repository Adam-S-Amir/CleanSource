# CleanSource

This app's goal is to aggregate articles from popular news sources and presents them in a user-friendly interface. For articles with similar headlines, it allows users to choose between viewing individual sources or a summarized version of all articles. If articles are unique to each source, the app provides options for viewing the single source and a summary option.

## How

- [x] Step 1: Android IDE setup
- [ ] Step 2: Plan The App
  - [ ] List out all the features:
    - [ ] Fetching news articles from multiple sources
    - [ ] Comparing similar headlines
    - [ ] Providing summaries
    - [ ] User interface for selecting sources and viewing summaries
    - [ ] Design UI/UX: Tools like Figma or Adobe XD can be helpful.
- [ ] Step 3: Fetch News Articles
  - [ ] Use APIs like NewsAPI, Google News API, or GDELT to fetch news articles.
  - [ ] Use Retrofit or OkHttp libraries to make network requests to these APIs.
- [ ] Step 4: Compare Headlines
  - [ ] Implement a text similarity algorithm to compare headlines.
  - [ ] Use libraries like Apache OpenNLP or Google's ML Kit for Natural Language Processing (NLP).
    - [ ] Group articles with similar headlines together.
- [ ] Step 5: Provide Summaries
  - [ ] Use a summarization algorithm to generate summaries of articles.
    - [ ] Use libraries like Sumy or implement my own using NLP techniques.
  - [ ] Provide an option for users to view summaries of grouped articles.
- [ ] Step 6: Build the UI
  - [ ] Display a list of news articles with options to view by source or summary.
    - [ ] Detail Screen: Show the full article or summary when a user selects an article.
    - [ ] Settings Screen: Allow users to customize their news sources and preferences.
- [ ] Step 7: Test The App
  - [ ] Write unit tests for the app to ensure it works as expected.
    - [ ] Test the UI, make sure it is intuitive and responsive.
  - [ ] Step 8: Deploy The App
  - [ ] Publish on Google Play.
    - [ ] Gather Feedback: Encourage users to provide feedback and use it to improve the app.

```KOTLIN
public interface NewsApiService {
    @GET("v2/top-headlines")
    Call<NewsResponse> getTopHeadlines(@Query("apiKey") String apiKey, @Query("sources") String sources);
}

// In Activity or ViewModel
Retrofit retrofit = new Retrofit.Builder()
    .baseUrl("https://newsapi.org/")
    .addConverterFactory(GsonConverterFactory.create())
    .build();

NewsApiService service = retrofit.create(NewsApiService.class);
Call<NewsResponse> call = service.getTopHeadlines("API_KEY", "bbc-news, cnn");
call.enqueue(new Callback<NewsResponse>() {
    @Override
    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
        if (response.isSuccessful()) {
            List<Article> articles = response.body().getArticles();
            // Process articles
        }
    }

    @Override
    public void onFailure(Call<NewsResponse> call, Throwable t) {
        // Handle failure
    }
});
```
