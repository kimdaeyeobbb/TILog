import { MongoClient } from "mongodb";

// Replace the uri string with your MongoDB deployment's connection string.
const uri = "mongodb://127.0.0";

const client = new MongoClient(uri);

async function run() {
    try {
        const database = client.db("hr");
        const movies = database.collection("emps");

        // query for movies that have a runtime less than 15 minutes
        // 40세이하 보기
        const query = { age: { $lt: 40 } };

        const options = {
            // sort returned documents in ascending order by title (A->Z)
            // 타이틀로 가져옴
            sort: { title: 1 },
            // Include only the `title` and `imdb` fields in each returned document
            projection: { _id: 0, title: 1, imdb: 1 },
        };

        // const cursor = movies.find(query, options);
        const cursor = movies.find(query);

        // print a message if no documents were found
        if ((await movies.countDocuments(query)) === 0) {
            console.log("No documents found!");
        }

        // replace console.dir with your callback to access individual elements
        await cursor.forEach(console.dir);
    } finally {
        await client.close();
    }
}
run().catch(console.dir);
