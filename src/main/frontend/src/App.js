import React, {useEffect, useState} from 'react';
import axios from 'axios';

function App() {
   const [posts, setPosts] = useState([]);

    useEffect(() => {
        axios.get('/api/posts')
          .then(response => setPosts(response.data))
          .catch(error => console.log(error));
      }, []);

    return (
     <div>
         <h1>게시물 목록</h1>
         {posts.length > 0 ? (
           <ul>
             {posts.map(post => (
               <li key={post.id}>
                 <h2>{post.title}</h2>
                 <p>{post.content}</p>
               </li>
             ))}
           </ul>
         ) : (
           <p>게시물이 없습니다.</p>
         )}
       </div>
    );
}

export default App;