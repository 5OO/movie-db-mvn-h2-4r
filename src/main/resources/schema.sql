CREATE TABLE IF NOT EXISTS movie(
   id                   BIGINT AUTO_INCREMENT PRIMARY KEY
  ,original_title       VARCHAR(86) NOT NULL
  ,overview             VARCHAR(1000) NOT NULL
  ,popularity           NUMERIC(10,6) NOT NULL
  ,release_date         DATE  NOT NULL
  ,revenue              BIGINT  NOT NULL
  ,runtime              NUMERIC(5,1) NOT NULL
  ,tagline              VARCHAR(252) NULL
  ,title                VARCHAR(86) NOT NULL
  ,vote_average         NUMERIC(4,1) NOT NULL
  ,vote_count           INTEGER  NOT NULL
);