// COUNTER

type Action = 
| { type: 'counter/minus' }
| { type: 'counter/plus', payload: number };

export default Action;

// Sandwich
type Ingredient = 'cheese' | 'bread' | 'salami';

export type ActionSandwich =
| { type: 'sandwich/addIngredient', payload: Ingredient }
| { type: 'sandwich/clear' }

// Book

type Book = {
    title: string;
    year: number;
    author: string
}

export type ActionBook =
| { type: 'books/add', payload: Book }
| { type: 'books/delete', payload: string }
| { type: 'books/editTitle', payload: { isbn: string, title: string } }