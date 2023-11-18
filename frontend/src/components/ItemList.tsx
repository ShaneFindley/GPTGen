import React, { useEffect, useState } from 'react';
import { useTranslation } from 'react-i18next';

const ItemList: React.FC = () => {
  const { t } = useTranslation();
  const [items, setItems] = useState<Item[]>([]);

  useEffect(() => {
    fetch('/api/items')
      .then(response => response.json())
      .then((data: Item[]) => setItems(data))
      .catch(error => console.error('Error fetching items:', error));
  }, []);

  return (
    <section aria-labelledby="item-list-heading">
      <h2 id="item-list-heading">{t('itemList.header')}</h2>
      <ul>
        {items.map(item => (
          <li key={item.id}>
            <dl>
              <dt>{t('itemList.id')}</dt>
              <dd>{item.id}</dd>
              <dt>{t('itemList.name')}</dt>
              <dd>{item.name}</dd>
            </dl>
          </li>
        ))}
      </ul>
    </section>
  );
};

export default ItemList;
