package ait.forum.dao;

import ait.forum.model.Post;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.function.Predicate;

public class ForumImpl implements Forum{

    private Post[] posts;
    private int size;

    public ForumImpl() {
        posts = new Post[0];
    }
    @Override
    public boolean addPost(Post post) {
        Post tmp = getPostById(post.getPostId());
        if (post == null || getPostById(post.getPostId()) != null) {
            return false;
        }
        posts = Arrays.copyOf(posts, posts.length + 1);
        posts[posts.length - 1] = post;
        size++;
        return true;
    }

    @Override
    public boolean removePost(int postId) {
        int index = searchById(postId);
        if (index < 0) {
            return false;
        }
        System.arraycopy(posts, index + 1, posts, index, size - index - 1);
        posts = Arrays.copyOf(posts, posts.length - 1);
        size--;
        return true;
    }

    @Override
    public boolean updatePost(int postId, String newContent) {
        int index = searchById(postId);
        if (index < 0) {
            return false;
        }
        posts[index].setContent(newContent);
        return true;
    }

    @Override
    public Post getPostById(int postId) {
        int index = searchById(postId);
        if (index < 0) {
            return null;
        }
        return posts[index];
    }

    @Override
    public Post[] getPostsByAuthor(String author) {
        return findByPredicate(p -> p.getAuthor().equals(author));
    }

    @Override
    public Post[] getPostsByAuthor(String author, LocalDate dateFrom, LocalDate dateTo) {
        return findByPredicate(p -> p.getAuthor().equals(author) && p.getDate().toLocalDate().compareTo(dateFrom) >= 0
                && p.getDate().toLocalDate().compareTo(dateTo) <= 0);
    }

    @Override
    public int size() {
        return size;
    }

    private int searchById(int postId) {
        for (int i = 0; i < size; i++) {
            if (posts[i].getPostId() == postId) {
                return i;
            }
        }
        return -1;
    }

    private Post[] findByPredicate(Predicate<Post> predicate) {
        Post[] res = new Post[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(posts[i])) {
                res[j++] = posts[i];
            }
        }
        return Arrays.copyOf(res, j);
    }
}
