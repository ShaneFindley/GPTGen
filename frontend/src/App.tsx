import React from 'react';
import ItemList from './components/ItemList';
import AddItemForm from './components/AddItemForm';
import './styles.css';

const App: React.FC = () => {
  const handleAddItem = (item: Item) => {
    console.log('Item added:', item);
  };

  return (
    <div>
      <ItemList />
      <AddItemForm onAddItem={handleAddItem} />
    </div>
  );
};

export default App;