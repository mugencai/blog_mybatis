# 個人用ブログ

## 技術スタック
**1.フロントエンド**
- WEBフレームワーク: Bootstrap
- UIフレームワーク: semantic-ui
- プラグイン
  - Markdownエディタ: editor.md
  - シンタックスハイライト: prismjs

**2.バックエンド**
- 開発フレームワーク: SpringBoot 2.7.0 
- DAOフレームワーク: Mybatis
- データベース: mysql
- テンプレートエンジン: thymeleaf


**3.その他**
- ツール: maven
- IDE: IntelliJ IDEA
- 構築環境: AWS EC2

## 機能
ブログはホームページと管理者ページに分かれています。
ログインしなくては管理者ページへアクセス出来ません。
\
\
**ホームページ**
- ホーム：記事一覧、記事詳細表示、最新記事表示
- カテゴリ：カテゴリ一覧、カテゴリより記事一覧
- タグ：タグ一覧、タグより記事一覧
- アーカイブ：掲載された時間より記事一覧
- 検索：キーワードより記事検索

**管理者ページ**
- 記事管理:記事一覧、記事投稿、記事変更、記事削除
- カテゴリ管理:カテゴリ一覧、カテゴリ増加、カテゴリ変更、カテゴリ削除
- タグ管理:タグ一覧、タグ増加、タグ変更、タグ削除
