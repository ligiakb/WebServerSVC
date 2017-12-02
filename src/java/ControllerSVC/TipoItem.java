/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerSVC;

/**
 *
 * @author ligia
 */
public class TipoItem {
    private int _IdTipoItem;
    private String _Nome;
    private int _Dosagem;
    private String _UnidadeDosagem;
    private int _Volume;
    private String _UnidadeVolume;

public int getIdTipoItem() {
    return _IdTipoItem;
} // getId
    
public void setIdTtipoItem(int id) {
    _IdTipoItem = id;
} // setId

public String getNome() {
    return _Nome;
} // getNome

public void setNome(String nome) {
    _Nome = nome;
} // setNome
    
public int getDosagem() {
    return _Dosagem;
} // getDosagem

public void setDosagem(int dosagem) {
    _Dosagem = dosagem;
} // setDosagem
    
public String getUnidadeDosagem() {
    return _UnidadeDosagem;
} // getUnidadeDosagem
    
public void setUnidadeDosagem(String unidosagem) {
    _UnidadeDosagem = unidosagem;
} // setUnidadeDosagem

public int getVolume() {
    return _Volume;
} // getVolume
    
public void setVolume(int volume) {
    _Volume = volume;
} // setVolume

public String getUnidadeVolume() {
    return _UnidadeVolume;
} // getUnidadeVolume
    
public void setUnidadeVolume(String univolume) {
    _UnidadeVolume = univolume;
} // setUnidadeVolume
}
