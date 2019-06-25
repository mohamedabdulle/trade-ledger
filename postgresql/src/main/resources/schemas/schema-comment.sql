DROP TABLE IF EXISTS Comment;
CREATE TABLE Comment
(
    CommentId SERIAL PRIMARY KEY,
    CommentText varchar(50),
    CommentDateTime timestamptz,
    CommentUserId varchar(50)
);