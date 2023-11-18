import React, { useState } from 'react';
import { useTranslation } from 'react-i18next';

const AddItemForm: React.FC<AddItemFormProps> = ({ onAddItem }) => {
  const { t } = useTranslation();
  const [name, setName] = useState<string>('');

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    fetch('/api/items', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ name }),
    })
      .then(response => response.json())
      .then((data: Item) => {
        onAddItem(data);
        setName('');
      })
      .catch(error => console.error('Error adding item:', error));
  };

  return (
    <section aria-labelledby="add-item-heading">
      <h2 id="add-item-heading">{t('addItemForm.header')}</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="item-name">{t('addItemForm.nameLabel')}</label>
          <input 
            type="text" 
            id="item-name" 
            value={name} 
            onChange={(e) => setName(e.target.value)} 
          />
        </div>
        <button type="submit">{t('addItemForm.addItemButton')}</button>
      </form>
    </section>
  );
};

export default AddItemForm;
