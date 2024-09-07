public class Post {
    private String content;
    private User author;
    private ArrayList<Comment> comments;

    public Post(String content, User author) {
        this.content = content;
        this.author = author;
        comments = new ArrayList<>();
    }

    // Get content
    public String getContent() {
        return content;
    }

    // Get author
    public User getAuthor() {
        return author;
    }

    // Add comment
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    // Get comments
    public ArrayList<Comment> getComments() {
        return comments;
    }
}