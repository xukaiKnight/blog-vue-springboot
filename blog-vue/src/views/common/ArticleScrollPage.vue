<template>
  <scroll-page :loading="loading" :offset="offset" :no-data="noData" v-on:load="load">
    <article-item v-for="a in articles" :key="a.id" v-bind="a"></article-item>
  </scroll-page>
</template>

<script>
  import ArticleItem from '@/components/article/ArticleItem'
  import ScrollPage from '@/components/scrollpage'
  import {getArticles} from '@/api/article'

    export default {
      name: "ArticleScrollPage",
      props: {
        offset: {
          type: Number,
          default: 100
        },
        page: {
          type: Object,
          default() {
            return {}
          }
        },
        query: {
          type: Object,
          default() {
            return {}
          }
        }
      },
  //  watch method
      created() {
        this.getArticles()
      },
      data() {
        return {
          loading: false,
          noData: false,
          innerPage: {
            pageSize: 5,
            pageNumber: 1,
            name: 'a.create_date',
            sort: 'desc'
          },
          articles: []
        }
      },
      methods: {
        load() {
          this.getArticles()
        },
        getArticles() {
          let that = this
          that.loading = true

          getArticles(that.query, that.innerPage).then(data => {
            let newArticles = data.data
            console.log(data)
            console.log(newArticles)
            if (newArticles && newArticles.length > 0) {
              that.innerPage.pageNumber += 1
              that.articles = that.articles.concat(newArticles)
            } else {
              console.log('nodata')
              that.noData = true
            }

          }).catch(error => {
            if (error !== 'error') {
              that.$message({type: 'error', message: '文章加载失败!', showClose: true})
            }
          }).finally(() => {
            that.loading = false
          })
        }
      },
      components: {
        'article-item': ArticleItem,
        'scroll-page': ScrollPage
      }
    }
</script>

<style scoped>
  .el-card {
    border-radius: 0;
  }

  .el-card:not(:first-child) {
    margin-top: 10px;

  }
</style>
