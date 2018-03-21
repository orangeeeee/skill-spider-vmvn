
/**
 * DZone sampleを改良する。
 * <p>
 * DZoneは、strategyにおいてDIにて生成するFactoryクラスでBean定義を使用して
 * コンストラクタ引数ありのクラスを生成しているが、現実的にはありえない為、
 * そこを改善する。
 * 現実的には、引数はケースバイケースなはずなので、引数がランダムである状態のサンプルを作成する。
 * </p>
 * @author kurata
 */
package jp.co.aimsoft.attendance.sample.dzone.strategy;