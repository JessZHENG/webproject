package com.example.webproject.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "information",type = "information")
public class Information {

    @Id//主键
    private String id;
    @Field(type= FieldType.Text,searchAnalyzer = "ik_smart",analyzer = "ik_smart")
    private String title;
    @Field(type= FieldType.Text,searchAnalyzer = "ik_smart",analyzer = "ik_smart")
    private String summary;
    @Field(type= FieldType.Text,searchAnalyzer = "ik_smart",analyzer = "ik_smart")
    private String content;

    public Information(){}

    public Information(String title, String summary, String content){
        this.title=title;
        this.summary=summary;
        this.content=content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString(){
        return String.format(
                "Information[id='%s',title='%s',summary='%s',content='%s']",
                id,title,summary,content
        );
    }
}
