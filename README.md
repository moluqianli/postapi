# postapi

```bash
GET		http://127.0.0.1:9000/posts
```
result
```json
[
  {
    "categories": [
      "周杰伦"
    ],
    "content": "阿萨德飒沓大苏打",
    "post_uuid": "aa7ee367-cbdd-4a5a-9a4e-c9a7e0d736aa",
    "publishing_date": 1439308800000,
    "title": "周杰伦梦想导师"
  }
]
```

```bash
POST	http://127.0.0.1:9000/post/save
```

request body
```json
{
    "title": "周杰伦梦想导师", 
    "categories": [
        "周杰伦"
    ], 
    "content": "阿萨德飒沓大苏打"
}
```


