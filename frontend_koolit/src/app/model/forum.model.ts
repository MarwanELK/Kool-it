// topic.model.ts
export interface Topic {
    id: string;
    title: string;
    description: string;
  }
  
  // discussion.model.ts
  export interface Discussion {
    id: string;
    topicId: string;
    content: string;
    author: string;
  }
  