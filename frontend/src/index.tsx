import React from 'react';
import ReactDOM from 'react-dom';
import { I18nextProvider } from 'react-i18next';
import i18n from 'i18next';
import App from './App';

i18n.init({
  interpolation: { escapeValue: false }, // React already does escaping
  lng: 'en', // default language
  resources: {
    en: {
      translation: {
        itemList: {
          header: 'Item List',
          id: 'ID',
          name: 'Name',
        },
        addItemForm: {
          header: 'Add Item',
          nameLabel: 'Name:',
          addItemButton: 'Add Item',
        },
      },
    },
    fr: {
      translation: {
        itemList: {
          header: 'Liste d\'articles',
          id: 'ID',
          name: 'Nom',
        },
        addItemForm: {
          header: 'Ajouter un article',
          nameLabel: 'Nom :',
          addItemButton: 'Ajouter un article',
        },
      },
    },
  },
});

ReactDOM.render(
  <I18nextProvider i18n={i18n}>
    <App />
  </I18nextProvider>,
  document.getElementById('root')
);
